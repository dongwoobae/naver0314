import React from 'react';
import {Alert} from "@mui/material";
import nofood from '../image/snoopyAvata/s10.JPG';
import {useParams} from "react-router-dom";

const Food = () => {
    //path의 파라미터 값 읽기
    const {food1, food2} = useParams();
    console.log(food1, food2);
    return (
        <div>
            <Alert severity={'error'}>Food 화면</Alert>
            <div style={{marginTop: '20px'}}>
                {
                    food1==null&&food2==null?
                        <div>
                            <h3>오늘은 점심을 안먹고 공부를 하겠습니다</h3>
                            <img src={nofood} alt={''}/>
                        </div>:
                        food1!=null&&food2==null?
                            <div>
                                <h2>오늘 저희 후식입니다</h2>
                                <img src={require(`../image/${food1}.jpg`)} alt={''} width={'200px'}/>
                            </div>:
                            <div>
                                <h2>오늘 저희 점심 메뉴입니다</h2>
                                <img src={require(`../image/${food2}.jpg`)} alt={''} width={'200px'}/><br/>
                                <img src={require(`../image/${food1}.jpg`)} alt={''} width={'200px'}/>
                            </div>
                }
            </div>
        </div>
    );
};

export default Food;
