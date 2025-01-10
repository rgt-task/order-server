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


# 사용 기술 스텍

# back end

# 구현 방법

