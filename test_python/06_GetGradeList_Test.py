import requests
import json

url = "http://localhost:8080/grade/course"
# UA伪装
header = {
    'User-Agent': 'Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36    (KHTML, like Gecko) Chrome/70.0.3538.25 Safari/537.36 Core/1.70.3775.400 QQBrowser/10.6.4208.400',
    'Authorization': "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJjbGFpbXMiOnsidHlwZUlkIjoxLCJ1c2VyTmFtZSI6ImFkbWluIiwidXNlcklkIjoxfSwiZXhwIjoxNzAzNTM0MzkwfQ.Us4ez6x4ZrwR9fnLBN6qSLv9UZKnGNKVpfRWHyEWiEI"
}
params = {
    "pageNum": 1,
    "pageSize": 10,
    "academicYear": "2021-2022学年秋季学期",
    "courseId": 1,
    "courseName": "制药业"
}
response = requests.get(url, params=params, headers=header)
response_json = response.json()
print(response_json)
