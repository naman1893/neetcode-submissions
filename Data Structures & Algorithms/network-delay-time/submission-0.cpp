class Solution {
public:
    int networkDelayTime(vector<vector<int>>& times, int n, int k) {
        priority_queue<pair<int,int>,vector<pair<int,int>>,greater<pair<int,int>>>pq;
        vector<int>distance(n+1,1000001);
        distance[k]=0;
        distance[0]=0;
        vector<vector<pair<int,int>>>list(n+1);
        for(auto time:times){
            list[time[0]].push_back({time[1],time[2]});
        }
        pq.push({0,k});
        while(pq.size()){
            auto [dist, parent] = pq.top();
            pq.pop();
            for(int i=0;i<list[parent].size();i++){
                if(distance[list[parent][i].first]>dist+list[parent][i].second){
                    pq.push({dist+list[parent][i].second,list[parent][i].first});
                    distance[list[parent][i].first]=dist+list[parent][i].second;
                }
            }
        }
        int ans=0;
        for(int i=0;i<n+1;i++){
            cout<<distance[i]<<" ";
            if(i!=k)
            ans=max(ans,distance[i]);
        }
        return ans==1000001?-1:ans;
 
    }
};
