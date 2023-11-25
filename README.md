# 🫧서비스 명
### DO WOR:RE
# 🫧서비스 소개

*각자의 마음속에는 수없이 많은 걱정들이 자리 잡고 있습니다.* <br>
*하지만 시간이 지나고 돌이켜보면, <br>그 걱정들이 우리를 더 성숙하고 강인하게 만들었음을 깨닫게 됩니다.* <br>

*이제, 당신의 걱정들을 아카이빙하여*<br> 
*미래의 어느 날, 과거의 내가 어떻게 이겨냈는지 돌아보는 시간을 가져보세요.* <br>
*어제의 당신은 오늘의 당신을 도와줄 거에요*

*지금의 고민과 걱정이 언젠가는 좋은 방향이 될 수 있도록,* <br>
*당신의 모든 순간을 함께 아카이브 해 드립니다.*

*지금의 내가 본 과거의 내 걱정, 다 괜찮았네요. <br>
미래의 내가 볼 지금의 내 걱정, 다 괜찮을 거에요.*
 
<U> **”현재의 내 걱정을 덜어주는 건 과거의 내 걱정들이었다.”** </U>
<br> 
걱정 기록 서비스, DO WOR:RE

# 🫧주요 기능
1. 걱정 작성하기
2. 걱정 리뷰하기
3. 과거 걱정에 대한 리뷰 작성하기
4. 랜덤 걱정 띄우기

# 🫧팀원 역할 분담
|<img width=150 src="https://avatars.githubusercontent.com/u/97405341?v=4" />|<img width=150 src="https://avatars.githubusercontent.com/u/114990782?v=4" />|<img width=150 src="https://avatars.githubusercontent.com/u/113780698?v=4" />|<img width=150 src="https://avatars.githubusercontent.com/u/93514333?v=4" />|
|:----:|:----:|:----:|:----:|
| [김상호](https://github.com/Marchbreeze) | [손명지](https://github.com/m6z1) | [엄현지](https://github.com/hyunjium) | [이삭](https://github.com/lsakee) |
|걱정 작성 화면|메인 화면|걱정 목록 화면|걱정 상세 보기 화면|


# 🫧컨벤션 규칙 & 브랜치 전략
### Git Convention
- **[FEAT]** : 새로운 기능 구현
- **[MOD]** : 코드 수정 및 내부 파일 수정
- **[ADD]** : 부수적인 코드 추가 및 라이브러리 추가, 새로운 파일 생성
- **[CHORE]** : 버전 코드 수정, 패키지 구조 변경, 타입 및 변수명 변경 등의 작은 작업
- **[DEL]** : 쓸모없는 코드나 파일 삭제
- **[UI]** : UI 작업
- **[FIX]** : 버그 및 오류 해결
- **[HOTFIX]** : issue나 QA에서 문의된 급한 버그 및 오류 해결
- **[MERGE]** : 다른 브랜치와의 MERGE
- **[MOVE]** : 프로젝트 내 파일이나 코드의 이동
- **[RENAME]** : 파일 이름 변경
- **[REFACTOR]** : 전면 수정
- **[DOCS]** : README나 WIKI 등의 문서 개정

### Branch Strategy & Convention
**Git flow**

1. 이슈 파기
    - `[유형] where / what`
    - ex) [UI] 로그인 뷰 / UI 구현
    
2. 브랜치 파기
    - `유형/#번호-what`
    - ex) feat/#11-login-view-ui
      
3. 작업하기
    - `[유형/#번호] what`
    - commit 예시
      <br>
        <img width=500 src="https://github.com/DO-SOPT-SOPKATHON/Team1-Android/assets/114990782/b8d79d58-0eea-45a9-bca5-3b8fd293daf2" />
4. PR 올리기
    - `[유형/#번호] where / what`
    - ex) Issue #11에 대해서 완료한 경우 : `[FEAT/#11] 로그인 뷰 / UI 구현`
    - merge 할 때 : `[MERGE] #11 -> develop`

# 🫧폴더링

```
├── api
|     ├── ApiFactory
|     ├── ServicePool
├── data
│     ├── dataclass
|     ├── datasource
│     ├── dto
│     │    ├── request
│     │    └── response
│     ├── repository
│     ├── mock
│     └── service
├── presentation
│     └── 화면 별 패키지명
|          ├── ViewModel
|          ├── Adaptor
|          └── Activity or Fragment
├── util
│     ├── interactor
│     └── model
```

# 🫧Before 안붕이 사진
<img width=500 src="https://github.com/DO-SOPT-SOPKATHON/Team1-Android/assets/114990782/e5f31ebb-e364-4084-a5f4-3f87d22e6dab">

# 🫧After 안붕이 사진
<img width=500 src="https://github.com/DO-SOPT-SOPKATHON/Team1-Android/assets/113780698/44b6a425-5310-4ca9-988f-a37a68f054c0">
