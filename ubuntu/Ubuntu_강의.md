# Ubuntu 강의

version : Ubuntu 20.04 LTS

VM : VMware Workstation Pro 16.0 / VMware Workstation Player 16.0



리눅스 초보자에서 리눅스 중급자 급으로 성장하자!



### 가상머신과 가상머신 소프트웨어의 개념

- 컴퓨터에 설치된 운영체제(호스트OS) 안에 가상의 컴퓨터를 만들고, 그 안에 또 다른 운영체제(게스트OS)를 설치/운영할 수 있도록 제작된 프로그램
- PC에 이미 설치되어 있는 Windows를 호스트 운영체제(Host Operating System, 호스트OS)라고 부르고, 가상머신에 설치할 그 외의 운영체제를 게스트 운영체제(Guest Operating System, 게스트OS)라고 부름
- 멀티부팅(Multi-Booting)과는 개념이 다름



### 가상머신 종류와 VMware

- VMware Workstation과 VMware Player 비교

| 구분/제품                      | VMware Workstation Pro                                    | VMware Workstation Player                                 |
| ------------------------------ | --------------------------------------------------------- | --------------------------------------------------------- |
| 호스트 운영체제                | Windows 7 이후의 64 bit Windows                           | Windows 7이후의 64bit Windows                             |
| 게스트 운영체제                | 모든 16bit, 32bit, 64bit Windows 대부분의 리눅스 운영체제 | 모든 16bit, 32bit, 64bit Windows 대부분의 리눅스 운영체제 |
| 라이선스                       | 유료                                                      | 유료 or 무료                                              |
| 라이선스 키                    | 유료                                                      | 무료인 경우 필요X                                         |
| 가상머신 생성 가능             | O                                                         | O                                                         |
| 스냅숏 기능                    | O                                                         | X                                                         |
| 가상 네트워크 사용자 설정 기능 | O                                                         | X                                                         |
| 비고                           | 여러가지 부가 기능 있음                                   | 부가 기능이 별로 없음                                     |

