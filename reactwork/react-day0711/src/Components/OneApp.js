import React, {useState} from 'react';
import {Alert, Button} from "@mui/material";
import OneSubApp from "./OneSubApp";

const OneApp = () => {
    const [inputArray,setInputArray] = useState([
        {sname:'신상슈즈',scolor:'orange',sprice:23000,sphoto:'15.jpg'}
    ]);
    const [inputValue,setInputValue] = useState({
        sname:'',
        sphoto:'',
        sprice:0,
        scolor:'#ffccff'
    });
    //각 입력 태그에서 호출할 이벤트
    const changeDateEvent = (e) =>{
        let {name,value}=e.target;
        setInputValue(
            {
                ...inputValue,//나머지 값들은 그대로 유지
                [name]:value//같은 name을 찾아서 value값 넣기
            }
        )
    }
    //상품 추가 버튼 이벤트
    const addProductEvent=()=>{
        setInputArray(inputArray.concat(inputValue));
        initDataEvent();
    }
    //입력값 초기화 버튼 이벤트
    const initDataEvent=()=>{
        setInputValue({
            sname:'',
            sphoto:'',
            sprice:0,
            scolor:'#ffccff'
        });
    }
    return (
        <div>
            <Alert>OneApp - 모든 입력값 하나의 변수에 넣기</Alert>
            <table className="table table-bordered" style={{width:'300px'}}>
                <tbody>
                <tr>
                    <th style={{backgroundColor: '#ccf',width:100}}>상품명</th>
                    <td>
                        <input type={'text'} className={'form-control'} value={inputValue.sname} name={'sname'}
                        onChange={changeDateEvent}/>
                    </td>
                </tr>
                <tr>
                    <th style={{backgroundColor: '#ccf'}}>가격</th>
                    <td>
                        <input type={'text'} className={'form-control'} value={inputValue.sprice} name={'sprice'}
                               onChange={changeDateEvent}/>
                    </td>
                </tr>
                <tr>
                    <th style={{backgroundColor: '#ccf'}}>색상</th>
                    <td>
                        <input type={'text'} className={'form-control'} value={inputValue.scolor} name={'scolor'}
                               onChange={changeDateEvent}/>
                    </td>
                </tr>
                <tr>
                    <th>상품 사진</th>
                    <td>
                        <select onChange={changeDateEvent} name={'sphoto'} className={'form-select'}>
                            <option disabled hidden selected={inputValue.sphoto===''}></option>
                            <option value={'14.jpg'}>플렛슈즈</option>
                            <option value={'23.jpg'}>여름용 모자</option>
                            <option value={'30.jpg'}>보석머리띠</option>
                            <option value={'32.jpg'}>투피스</option>
                            <option value={'31.jpg'}>자켓</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td colSpan={2} align={'center'}>
                        <Button variant={'contained'} color={'success'} size={'small'}
                        onClick={addProductEvent}>상품 추가</Button>&nbsp;
                        <Button variant={'contained'} color={'info'} size={'small'}
                        onClick={initDataEvent}>입력값 초기화</Button>
                    </td>
                </tr>
                {/*<tr>*/}
                {/*    <td colSpan={2} align={'center'}>*/}
                {/*        <h4>*/}
                {/*            상품명 : {inputValue.sname}<br/>*/}
                {/*            색 상 : {inputValue.scolor}<br/>*/}
                {/*            가 격 : {inputValue.sprice}<br/>*/}
                {/*            사 진 : {inputValue.sphoto}*/}
                {/*        </h4>*/}
                {/*    </td>*/}
                {/*</tr>*/}
                </tbody>
            </table>
            <h4>총 {inputArray.length} 개의 배열 데이터가 있습니다</h4>
            <table className={'table table-bordered'} style={{width:400}}>
                <tbody>
                {
                    inputArray.map((item,idx) => (
                        <OneSubApp key={idx} idx={idx} item={item}/>
                    ))
                }
                </tbody>
            </table>
        </div>
    );
};

export default OneApp;
