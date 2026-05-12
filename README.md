# spring-push-telegram-sample

텔레그램 봇을 통해 푸시 메시지를 전송하는 REST API 샘플 프로젝트

## 기술 스택

- Kotlin 1.9.22
- Spring Boot 3.2.5
- Jasypt 3.0.5

## 환경변수 설정

| 변수명 | 설명 |
|---|---|
| `JASYPT_KEY` | Jasypt 암호화 키 |

## API

### 메시지 전송

```
POST /api/telegram/send
```

**Request**
```json
{
  "chatId": "123456789",
  "message": "안녕하세요!"
}
```

**Response**
```json
{
  "success": true,
  "chatId": "123456789",
  "message": "안녕하세요!"
}
```
