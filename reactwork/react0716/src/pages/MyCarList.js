import React, {useEffect} from 'react';
import axios from "axios";
import 'react-bootstrap';

const formatCurrency = (value) => {
return new Intl.NumberFormat('ko-KR', {style: 'currency', currency: 'KRW'}).format(value);
}

const MyCarList = () => {
    const [list, setList] = React.useState([]);
    const carList=()=>{
        axios.get("/mycar/list").then((res)=>{
            setList(res.data);
        })
    }
    useEffect(()=>{
        carList();
    },[]);
    return (
        <div>
            <table className="table table-striped" style={{width:'660px'}}>
                <thead className={'table table-info'}>
                <tr>
                    <th style={{width:'fit-content'}}>번호</th>
                    <th style={{width:'150px'}}>차량명</th>
                    <th style={{width:'130px'}}>구입일자</th>
                    <th style={{width:'150px'}}>차량 가격</th>
                    <th>차량 색상</th>
                </tr>
                </thead>
                <tbody>
            {
                list&&
                list.map((item,index)=>{
                    return(
                    <tr>
                        <td>{index+1}</td>
                        <td>{item.carname}</td>
                        <td>{item.carguip}</td>
                        <td>{formatCurrency(item.carprice)}</td>
                        <td style={{display:'flex',justifyContent:'space-between'}}>{item.carcolor}&emsp;
                        <div style={{backgroundColor:item.carcolor,width:'50px',height:'50px',
                        border:'1px solid black'}}></div></td>
                    </tr>
                    )
                })
            }
                </tbody>
            </table>
        </div>
    );
};

export default MyCarList;
