# 🖍️Google Colab를 사용해 얼굴 인식해보기
### 1. Google Colab
    - GPU 및 TPU 가속이 제공됨
    - Python 기반의 face_recognition 패키지가 제공됨

### 2. 용어정리
    - Face Detection
        - 사진에서 얼굴을 찾아내 얼굴이 표시된 영역을 알아냄
    - Face Recognition
        - 감지된 얼굴 데이터를 기반으로 동일한 인물을 찾아내 인식 (= 얼굴인식)

### 3. 실습
    3.1. Face Detection
        - pip 명령어를 사용해 face_recognition 패키지 설치
        - 구글 드라이브를 통해 인물이 있는 이미지를 가져옴
        - face_recognition 패키지의 기본HOG(Histogram of Oriented Gradient) 모델을 사용해 얼굴감지
            - 코드 상의 face_locations가 이 역할을 수행
        - 사각형 그려줌
    3.2. Face Recognition
        - 인식된 얼굴영역에서 데이터를 추출해 여러 사진들이 동일한 사람인지를 확인
            - 인식된 얼굴을 encoding하여 데이터 구조를 변경
            - 사진간의 encoding된 데이터를 비교해서 두 사진간의 distance 차이로 동일인인지 타인인지 확인이 가능
                - distance 값이 0.6 이상이면 타인, 미만이면 동일인

### 4. 결과물
    - face detection 인식은 잘 되었으나, face recognition의 경우 동일인이 아님에도 불구하고 대체로 작은 distance 값들이 나타났다. 허나 동일인은 가장 작은 차이값이 나타났다.