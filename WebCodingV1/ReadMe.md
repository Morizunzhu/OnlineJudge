问题列表查询  后台api

####Tips
``确认申请时，当确认了最后一名比赛参赛人员，即比赛人数已满，需修改access状态``

#### 4-4任务
``
测试linux部分
``
#### 5.1任务
````
1.测试题目删除
2.题目删除时添加判断，是否题目在某场竞赛中
3.测试公告删除 
4.竞赛页面进入公告页面时，新建公告应该与竞赛绑定,删除公告也应与竞赛解绑
5.fastJson不建立新对象可能会引起的循环引用
6.前台竞赛列表，用户可以查询到公开竞赛和自己参加的隐私竞赛
````
#### 5.2次要任务
````
1.添加竞赛中 添加对info属性的操作
````
#### 5.3 linux run sh
````
docker build -t mo/judge:v1.8 .
docker run -it  -v /mnt/hgfs/webapp/problem_cases:/oj-home/problem_cases:ro -d mo/judge:v1.8
docker ps
docker rm ...
docker images 
docker rmi ...
docker exec -it ... /bin/bash 
````