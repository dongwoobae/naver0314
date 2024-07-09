import React from 'react';

const SixApp = () => {
    const names=["장미꽃","안개꽃","다알리아","목수국","채송화"];
    const namelist=names.map(function(item,idx){
        return <li>{idx} : {item}</li>
    });
    //위의 코드를 화살표 함수로
    const nameList =names.map((item,idx)=> {
        return <li key={idx}>{idx} : {item}</li>
    });
    return (
        <div>
            <h3 className={"alert alert-secondary"}>SixApp</h3>
            <h5>미리 변수에 저장 후 출력 #1</h5>
            <ul>
            {nameList}
            </ul>
            <hr/>
            <h5>직접 map으로 반복</h5>
            {
                names.map((item,idx)=> {
                    return <h5 key={idx}>{idx} : {item}</h5>
                })
            }
        </div>
    );
};

export default SixApp;