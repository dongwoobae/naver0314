import React, {useRef, useState} from 'react';
import {Alert, Button} from "@mui/material";
import {keyboard} from "@testing-library/user-event/dist/keyboard";

const FourApp = () => {
    const [result,setResult]=useState('');
    const nameRef = useRef('');
    const korRef = useRef(0);
    const engRef = useRef(0);

    //버튼 이벤트
    const resultButtonEvent=()=>{
        //입력값 읽기
        let name=nameRef.current.value;
        let kor=korRef.current.value;
        let eng=engRef.current.value;
        
        let tot=Number(kor)+Number(eng);
        let avg=tot/2;
        
        let s=`이름: ${name}
        국어 점수:${kor}점
        영어 점수:${eng}점
        총점 : ${tot}점
        평균 : ${avg}점
        `
        setResult(s);
        //입력값 초기화
        nameRef.current.value='';
        korRef.current.value='';
        engRef.current.value='';

        nameRef.current.focus();
    }
    return (
        <div>
            <Alert>FourApp - useRef 응용 예제</Alert>
            <table className={'table table-bordered'} style={{width:'300px'}}>
                <tbody>
                <tr>
                    <th style={{width: '100px'}} className={'table-info'}>이름</th>
                    <td>
                        <input type={'text'} className={'form-control'} ref={nameRef}/>
                    </td>
                </tr>
                <tr>
                    <th style={{width: '100px'}} className={'table-info'}>국어 점수</th>
                    <td>
                        <input type={'text'} className={'form-control'} ref={korRef}/>
                    </td>
                </tr>
                <tr>
                    <th style={{width: '100px'}} className={'table-info'}>영어 점수</th>
                    <td>
                        <input type={'text'} className={'form-control'} ref={engRef}/>
                    </td>
                </tr>
                <tr>
                    <td colSpan={2} align={'center'}>
                        <Button variant={'contained'} color={'error'}
                        onClick={resultButtonEvent}>결과 출력하기</Button>
                    </td>
                </tr>
                <tr>
                    <td colSpan={2} style={{height:'100px',fontSize:'16px',whiteSpace:'pre-line',backgroundColor:'bisque'}}>{result}</td>
                </tr>
                </tbody>
            </table>
        </div>
    );
};

export default FourApp;
