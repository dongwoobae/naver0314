import React from 'react';
import OneApp from "./OneApp";
import TwoApp from "./TwoApp";
import ThreeApp from "./ThreeApp";
import FourApp from "./FourApp";
import 'bootstrap/dist/css/bootstrap.min.css';

const MainApp = () => {
    const [app, setApp] = React.useState(1);
    const selectApp = (e) => {
        setApp(e.target.value);
    }
    return (
        <div>
            <h1 style={{margin:'10px'}}>react 공부 day 0711</h1>
            <select onChange={selectApp} className={'form-select'} style={{maxWidth: 'fit-content',marginLeft:'10px'}}>
                <option value={1}>OneApp - 모든 입력값 하나의 변수에 넣기</option>
                <option value={2}>TwoApp - 객체 배열 출력 - tr rowSpan</option>
                <option value={3}>ThreeApp - 데이터 추가,삭제,출력(부모, 자식 컴포넌트)</option>
                <option value={4}>FourApp - 문제</option>
            </select>
            <hr/>
            {
                Number(app) === 1 ? <OneApp/> : Number(app) === 2 ? <TwoApp/> : Number(app) === 3 ?
                    <ThreeApp/> : <FourApp/>
            }
        </div>
    );
};

export default MainApp;
