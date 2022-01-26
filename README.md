# joinUs_maven

<spring-boot 기반 maven 빌드 샘플코드 설명>

1. 로그인/회원가입 페이지 구축
   - Security Config 작성
   - 로그인 된 사용자의 패스워드 암호화 처리 -> passwordEncoder 를 사용
   - WebSecurityConfigurerAdapter 를 사용하여 Spring Security 설정 후 적용
   - 페이지에 role 을 주어서 권한을 가진사람만 페이지에 접속할수 있도록 role 규칙 설정

2. welcome 페이지 구축 (role이 있는 사용자만 접근가능)
   - mysql jdbc driver 사용하여 사용자 어카운트 정보를 저장하고 있는 데이터베이스와 연동
   - DB 에 사용자 정보를 등록 & 불러오는 메소드 구현
     -> UserDetailService 인터페이스를 통해 사용
     
 <프로젝트 build 순서>

1. mvn clean -> 이전 빌드로 인해 남아있는 산출물을 제거
2. mvn package -> 실행가능한 jar 파일 생성
3. target -> libs 디렉토리 안에 
