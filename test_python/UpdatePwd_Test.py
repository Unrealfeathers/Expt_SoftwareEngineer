import requests
import json

url = "http://localhost:8080/user/updatePwd"
header = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36    (KHTML, like Gecko) Chrome/70.0.3538.25 Safari/537.36 Core/1.70.3775.400 QQBrowser/10.6.4208.400',
    "Authorization": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGFpbXMiOnsidXNlck5hbWUiOiIxMjM0NTYiLCJ1c2VySUQiOjd9LCJleHAiOjE3MDMzNjExNjR9.fcjKvo365BL1-PIQhZ8zYz9V4_04GYyPkXXBJLwxqOg",
    "Content-Type": "application/json"
}
params = {
    "oldPwd": "123456",
    "newPwd": "654321",
    "rePwd": "654321"
}
payload = json.dumps(params)
response = requests.patch(url, data=payload, headers=header)
response_json = response.json()
print(response_json)
