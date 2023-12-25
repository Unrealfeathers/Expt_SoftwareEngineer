"""
接口功能描述: 获取用户信息接口
接口请求方法: get
接口请求地址: http://localhost:8080/user/info
接口请求参数: header
接口请求参数格式: json
接口请求参数说明: Authorization: token
接口返回数据类型: json
接口返回参数说明: code/message/data
备注: 无
"""
import requests

url = "http://localhost:8080/user/info"
header = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36    (KHTML, like Gecko) Chrome/70.0.3538.25 Safari/537.36 Core/1.70.3775.400 QQBrowser/10.6.4208.400',
    "Authorization": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGFpbXMiOnsiVHlwZUlkIjoiMSIsInVzZXJOYW1lIjoiYWRtaW4iLCJ1c2VySWQiOjF9LCJleHAiOjE3MDM1MTk2NTd9.lTmJOp2c6LPqAO0KrsTMmjHrfmWvx_YdwG4kLPc1Elg"
}
response = requests.get(url, headers=header)
response_json = response.json()
print(response_json)
