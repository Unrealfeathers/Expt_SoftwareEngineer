import requests

# url = "http://localhost:8080/user/signup"
url = "http://localhost:8080/user/login"
# UA伪装
header = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36    (KHTML, like Gecko) Chrome/70.0.3538.25 Safari/537.36 Core/1.70.3775.400 QQBrowser/10.6.4208.400'
}
# 传入的参数
data = {
    "username": "123456",
    "password": "123456"
}

# 发送请求
response = requests.post(url, data=data, headers=header)
response_json = response.json()
print(response_json)
