import React from 'react';
import {Alert} from "@mui/material";
import {DeleteForeverOutlined} from "@mui/icons-material";

const OneApp = () => {
    const [msg, setMsg] = React.useState(['Happy','안녕','BitCamp']);
    //메세지 입력 후 Enter 시 이벤트
    const addMsgEvent=(e)=>{
        if(e.key==='Enter'){
            setMsg(msg.concat(e.target.value));
            e.target.value="";
        }
    }
    //i번지의 메세지 삭제하는 함수
    const deleteMsg=(index)=>{
        //배열을 db에 보내기 전에 수정을 할 시 사용
        // setMsg([
        //     //slice 로 삭제하기
        //     // ...msg.slice(0,index),
        //     // ...msg.slice(index+1,msg.length)
        // ]);
        //인덱스가 받아온 index와 같은 것만 빼고 담아라
        setMsg(msg.filter((m,n)=>n!==index))
    }
    return (
        <div>
            <Alert>OneApp- 배열에 데이터 추가, 삭제</Alert>
            <hr/>
            <input type={'text'} className={'form-control'} style={{width:'300px'}}
            placeholder={'메세지 입력 후 엔터'} onKeyUp={addMsgEvent}/>
            <hr/>
            <h3 style={{color:'red'}}>배열 데이터 출력</h3>
            <Alert severity="info">총 {msg.length}개의 메세지가 있습니다</Alert>
            {
                //msg 값이 null 값이 넘어오면 실행이 안되게
                msg &&
                msg.map((item,index)=>{
                    return <h4 key={index}>
                        {item}&nbsp;&nbsp;
                        <DeleteForeverOutlined style={{color:'red',cursor:'pointer'}}
                                               onClick={()=>deleteMsg(index)}/>
                    </h4>
                })
            }
        </div>
    );
};

export default OneApp;
