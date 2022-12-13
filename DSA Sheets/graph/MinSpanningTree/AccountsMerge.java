//yt:https://www.youtube.com/watch?v=FMwpt_aQOGw&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=49
//lc:https://leetcode.com/problems/accounts-merge/description/

import java.util.*;

class Solution {
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        int m = accounts.size();
        DisjointSet ds = new DisjointSet(m);

        // part 1
        /*
         * create a hashmap that stores the email and node that it belongs to
         * for testcase2:
         * {
         * Hanzo1@m.co = 3,
         * Fern5@m.co = 4,
         * Gabe3@m.co = 0,
         * Fern1@m.co = 4,
         * Kevin5@m.co = 1,
         * Gabe0@m.co = 0,
         * Kevin0@m.co = 1,
         * ...
         * Ethan5@m.co = 2
         * }
         */
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < m; i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String getMail = accounts.get(i).get(j);

                if (!map.containsKey(getMail))
                    map.put(getMail, i);// add the mail if it doesn't exist in the map
                else
                    ds.unionBySize(map.get(getMail), i); // if the mail already exists in the map that would mean it
                                                         // belongs to already present node (parent node) in the hashmap
                                                         // so we will merge the current node with the already present
                                                         // node.
            }
        }
        // at this point we've finished creating the disjoint set

        // part 2
        // all the mails along with their nodes are present in the hashmap, now we need
        // to merge the mails that belong to the same parent node into a single list
        List<List<String>> mergedMails = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            mergedMails.add(new ArrayList<>());
        }

        for (String key : map.keySet()) {
            int idx = ds.findParent(map.get(key)); // determine the parent node of each mail
            mergedMails.get(idx).add(key); // add the mail in the list that belongs to its parent node
        }

        // part 3
        // currently we have all the nodes in lists according to their parent nodes but
        // we still need to add the user name and sort the lists.
        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            if (mergedMails.get(i).size() == 0)
                continue;

            Collections.sort(mergedMails.get(i));

            List<String> temp = new ArrayList<>();
            String user = accounts.get(i).get(0);// get the username from accounts list
            temp.add(user);

            for (int j = 0; j < mergedMails.get(i).size(); j++) { // add the mails that belong to current user
                temp.add(mergedMails.get(i).get(j));
            }

            ans.add(temp);
        }
        System.out.println(map);
        return ans;
    }
}

// Disjoint set class
class DisjointSet {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public DisjointSet(int n) {
        for (int i = 0; i <= n; i++) {
            parent.add(i);
            size.add(1);
        }
    }

    public int findParent(int node) {
        if (node == parent.get(node)) {
            return node;
        }
        int p = findParent(parent.get(node));
        parent.set(node, p);
        return parent.get(node);
    }

    public void unionBySize(int u, int v) {
        int pu = findParent(u);
        int pv = findParent(v);
        if (pu == pv)
            return;
        if (size.get(pu) < size.get(pv)) {
            parent.set(pu, pv);
            size.set(pv, size.get(pv) + size.get(pu));
        } else {
            parent.set(pv, pu);
            size.set(pu, size.get(pv) + size.get(pu));
        }
    }
}