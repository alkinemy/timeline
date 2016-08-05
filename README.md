타임라인 서비스

0. 개발 환경
    - MacOSX
    - IntelliJ 2016.1.3
    - Spring boot 1.3.7.RELEASE
    - Java8
    - MySQL

1. 구현 기능
    - 뉴스피드
        - 팔로잉한 사람들의 메시지 확인 API
        - 현재 보여지는 메시지의 이후 메시지 로딩 API
    - 팔로우
        - 타인 팔로잉 API
        - 타인 언팔로잉 API
        - 팔로워 리스트 API
        - 팔로잉 리스트 API
    - 포스팅
        - 메시지 포스팅 API
    - 유저
        - 가입 API
        - 로그인 API
        - 다른 유저 정보 확인(유저 팔로잉 리스트, 팔로워 리스트, 해당 유저가 입력한 포스팅 리스트) API
    - 활동 로그
        - 팔로잉 기록, 팔로워가 추가된 기록, 포스팅 추가된 기록을 남기는 기능
        - 위 기록을 제공하는 API

2. 구조
    - 크게 client, server, member, common 네 컴포넌트로 구성됨, 실행되는건 client, server, member 이렇게 세 개
    - client: front server, 기능 테스트용으로 개발하였음(UI도 일부 있지만 테스트를 위해 간단하게만 만들었습니다)
    - server: backend server, 주요 기능(뉴스피드, 팔로우, 포스팅, 활동 로그 등) API 제공
    - member: 유저 정보 제공
    - common: 나머지 세 컴포넌트의 공통되는 요소를 모아놓음
    - 처음에는 모놀리틱으로 하나의 컴포넌트에 모든 기능을 만들었는데 역할에 따라서 컴포넌트를 나눠서 개발해보고싶어서 나눴습니다
    - client는 DB에 커넥션을 가지지 않고 member와 server 컴포넌트에 rest api로 필요한 정보를 요청합니다
    - DB에는 유저 정보, 팔로우 정보, 메시지, 활동 로그를 저장합니다(resources/db/migration 참고)

3. 빌드
    - ./gradlew timeline-client:build
    - ./gradlew timeline-server:build
    - ./gradlew timeline-member:build

4. 실행
    - SPRING_PROFILES_ACTIVE=local ./gradlew timeline-client:bootRun
    - SPRING_PROFILES_ACTIVE=local ./gradlew timeline-server:bootRun
    - SPRING_PROFILES_ACTIVE=local ./gradlew timeline-member:bootRun
    - build로 생성된 jar를 직접 실행해도 됨

5. 접속
    - client: http://localhost:19010
    - server: http://localhost:19011
    - member: http://localhost:19012