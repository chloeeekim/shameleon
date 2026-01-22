# Shameleon

API Mocking 서비스

## 사전 요구사항

- JDK 21+ (가상 스레드 지원)
- Node.js 18+
- Docker & Docker Compose (PostgreSQL 실행용)
- npm 또는 pnpm

## 로컬 실행 방법

### 1. 의존성 설치

```bash
# 루트 레벨 의존성 설치
npm install
```

### 2. 데이터베이스 시작

다음 명령어로 PostgreSQL을 실행 및 중지할 수 있다:

```bash
npm run start:db
npm run stop:db
```

### 3. 백엔드 및 프론트엔드 실행

루트 디렉토리에서 다음 명령으로 백엔드와 프론트엔드 동시에 실행할 수 있다:

```bash
npm run dev
```

또는 각 서비스를 별도 터미널에서 실행할 수 있다:

```bash
npm run dev:backend
npm run dev:frontend
```

## 접속 정보

- Frontend: http://localhost:3000
- Backend: http://localhost:8080
- PostgreSQL: localhost:15432
  - Database: `shameleon`
  - Username: `shameleon`
  - Password: `shameleon`
