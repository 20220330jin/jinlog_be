## 프로젝트 구조
- Controller -> Service -> Repository
  - Service -> ServiceImpl
  - Repository -> RepositoryImpl
- DTO

## 작명
- 메서드
  - Controller/Service/Repository 모두 가능하면 일치
  - ex) getPosts(Controller), getPosts(Service), getPosts(Repository), getPosts(DTO)
  - 