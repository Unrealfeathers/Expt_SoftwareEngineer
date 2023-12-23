"""
接口功能描述: 更新用户密码
接口请求方法: patch
接口请求地址: http://localhost:8080/user/updatePwd
接口请求参数: header params
接口请求参数格式: json
接口请求参数说明: Authorization: token
接口返回数据类型: json
接口返回参数说明: code/message/data
备注: 无
"""
import requests
import json

url = "http://localhost:8080/user/updatePwd"
header = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36    (KHTML, like Gecko) Chrome/70.0.3538.25 Safari/537.36 Core/1.70.3775.400 QQBrowser/10.6.4208.400',
    "Authorization": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGFpbXMiOnsidXNlck5hbWUiOiIyMzIzMjMiLCJ1c2VySWQiOjV9LCJleHAiOjE3MDMzNzc3NzN9.h0LoglJEi1GaJDM_ox8OmqTrIqtYf25uqDTi5vZrubc",
    "Content-Type": "application/json"
}
params = {
    "oldPwd": "12345678",
    "newPwd": "654321",
    "rePwd": "654321"
}
payload = json.dumps(params)
response = requests.patch(url, data=payload, headers=header)
response_json = response.json()
print(response_json)
