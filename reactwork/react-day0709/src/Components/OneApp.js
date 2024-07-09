import React from 'react';
import {AccessAlarm} from "@mui/icons-material";
import {styled} from "styled-components";
import {Button} from "@mui/material";

const OneApp = () => {
    //styled-components 태그가 지정된 탬플릿 리터럴을 활용하여
    //구성요소의 스타일을 지정합니다.
    //h1 태그에 스타일을 추가해보자
    const Title=styled.h1`
        width: 500px;
        height: 100px;
        line-height: 100px;
        font-size: 1.5em;
        text-align: center;
        color: orange;
    `;
    const Title2=styled(Title)`
        color: orangered;
        border-bottom: 5px solid orange;
    font-weight: bold;
    font-size: 3em;
    font-style: italic
    `;
    //Button에 스타일을 추가해서 적용
    const MyButton=styled.button`
        border: 2px solid black;
        color: orangered;
        width: fit-content;
        height: fit-content;
        min-height: 50px;
        min-width: 80px;
        border-radius: 7px;
        margin: 5px;
        padding: 5px;
    `;
    const MyButton2=styled(MyButton)`
    background-color: cornflowerblue;
    box-shadow: 5px 5px 5px gray;
    `;
    return (
        <div>
            <h3 className={"alert alert-danger"}>
                <AccessAlarm/>&nbsp;
                OneApp-styled-component</h3>
            <Title>Hello Title</Title>
            <Title2>Hello Title2</Title2>
            <h1>Hello H1</h1>
            <Button variant={"contained"}>거절하기</Button>
            <Button variant={"disabled"}>수락하기</Button>
            <MyButton>마이 버튼</MyButton>
            <MyButton2>마이 버튼 커스텀</MyButton2>
        </div>
    );
};

export default OneApp;