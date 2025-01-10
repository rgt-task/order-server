# 프로젝트 시퀀스 설명
![image](https://github.com/user-attachments/assets/5673df17-b6ec-4866-b342-fcef08d42731)
1. client에서 post요청으로 주문 정보를 보냅니다
```
{
  "food": "떡볶이",
  "quantity": 7
}
```
2. 받은 데이터를 아래와 같은 형식으로 메모리에 저장
( id값을 1씩 올려주면서 저장 )
```
{
  "id" : 1
  "food": "떡볶이",
  "quantity": 7
  "status": "접수됨"
}
```

3. 그다음 위의 정보를 지정된 `Rabbitmq`로 보냄  
`RabbitMq`는 `docker-compose`로 사용하였습니다  
`RabbitMq`에서 기본적으로 제공하는 `amq.direct` `exchange`로 주문 정보를 보냅니다  
그럼 해당 `exchange` 에 `binding`된 `queue`로 주문정보를 보냅니다

4. `queue`로 주문정보를 보낸뒤에  
클라이언트로 저장된 주문의 id를 response해 줍니다

5. `queue`를 consume 하고있는 websocket 서버가  
`queue`에 메세지가 들어오게 되면 그것을 읽음

6. 읽어온 데이터를 websocket으로 연결된 클라이언트에게 브로드캐스팅으로 뿌려줍니다


# websocket을 위해 사용한 기술들

### stomp
처음에는 확장성을 위해서 이것을 써야된다고 gpt로 확인후 사용했는데  
확인해보니 해당 프로젝트에서는 websocket은 브로드캐스팅용으로만 사용되고 송수신을 다 담당하지 않기 때문에  
안써도 됨을 추후에 확인하였으나  
stomp을 사용하지 않는다면 WebSocket 세션 관리와 메시지 전송 등의 기능을 직접 구현해야해서  
쉽게 구현 가능한 stomp방식으로 구현하였습니다 

### sockjs
다양한 클라이언트에서 websocket 사용을 위해


# back end
- 디자인 패턴 : DDD 4 layered를 흉내내려고 노력하였습니다  
![image](https://github.com/user-attachments/assets/3758f84a-c921-4b7d-9074-f2a6e7c1e7a7)

# frontend
- 전체적인 Ui는 `v0`, `cursor ai`를 사용하여 작업하였습니다

- `localhost:3000`에 접근을 하자마자 websocket 연결을 먼저 해놓기 위해서  
`nextjs`의 최상위 `layout`에서 `websocket`연결을 담당하도록 하였습니다

