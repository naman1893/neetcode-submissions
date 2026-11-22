class Solution {
public:
    bool validTree(int n, vector<vector<int>>& edges) {
        vector<vector<int>>adj(n);
        for(auto i:edges){
            adj[i[0]].push_back(i[1]);
            adj[i[1]].push_back(i[0]);
        }
        queue<pair<int,int>>q;
        vector<int>visited(n,0);
        q.push({0,-1});
        visited[0]=1;
        int count=0;
        while(q.size()){
            auto [top,parent]=q.front();
            count++;
            // cout<<to??p<<" "<<parent<<endl;
            q.pop();
            for(int i=0;i<adj[top].size();i++){
                if(parent!=adj[top][i]){
                    if(visited[adj[top][i]]==1){
                        return false;
                    }else{
                        q.push({adj[top][i],top});
                        visited[adj[top][i]]=1;
                    }
                }
            }
        }
        return count==n?true:false;
    }
};
