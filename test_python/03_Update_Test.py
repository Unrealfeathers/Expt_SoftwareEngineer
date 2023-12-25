"""
接口功能描述: 更新用户信息
接口请求方法: put
接口请求地址: http://localhost:8080/user/update
接口请求参数: header params
接口请求参数格式: json
接口请求参数说明: Authorization: token
接口返回数据类型: json
接口返回参数说明: code/message/data
备注: 无
"""
import requests
import json

url = "http://localhost:8080/user/update"
header = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36    (KHTML, like Gecko) Chrome/70.0.3538.25 Safari/537.36 Core/1.70.3775.400 QQBrowser/10.6.4208.400',
    "Authorization": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGFpbXMiOnsidXNlck5hbWUiOiJhZG1pbiIsInVzZXJJZCI6MX0sImV4cCI6MTcwMzUxMTkyOH0.j4Maqe-TQXRaD3XEn1vBuqZFirjWpSvp1Sc7YtZuKUU",
    "Content-Type": "application/json"
}
params = {
    "userName": "admin",
    "email": "215256@stu.cn"
}
payload = json.dumps(params)
response = requests.put(url, data=payload, headers=header)
response_json = response.json()
print(response_json)
