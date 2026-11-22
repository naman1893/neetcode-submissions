class Solution {
public:
    vector<int> findOrder(int numCourses, vector<vector<int>>& prerequisites) {
        vector<vector<int>>adj(numCourses);
        vector<int>indegree(numCourses,0);
        for(int i=0;i<prerequisites.size();i++){
            indegree[prerequisites[i][0]]++;
            adj[prerequisites[i][1]].push_back(prerequisites[i][0]);
        }
        queue<int>q;
        vector<int>visited(numCourses,0);
        vector<int>ans;
        for(int i=0;i<indegree.size();i++){
            if(indegree[i]==0){
                q.push(i);
                visited[i]=1;
                ans.push_back(i);
            }
            
        }
        while(q.size()){
            int top=q.front();
            q.pop();
            for(int i=0;i<adj[top].size();i++){
                indegree[adj[top][i]]--;
                if(indegree[adj[top][i]]==0&&visited[adj[top][i]]==0){
                    q.push(adj[top][i]);
                    visited[adj[top][i]]=1;
                    ans.push_back(adj[top][i]);
                }
            }
        }

        for(int i=0;i<visited.size();i++){
            if(visited[i]==0){
                return {};
            }
        }
        return ans;
    }
};
