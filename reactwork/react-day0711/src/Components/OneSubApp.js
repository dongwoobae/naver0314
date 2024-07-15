import React from 'react';
import {CloseSharp} from "@mui/icons-material";

const OneSubApp = (prop) => {
    let {idx,item,onDelete}=prop;
    const formatCurrency = (value) =>{
        return new Intl.NumberFormat('ko-KR',{style:'currency',currency:'KRW'}).format(value);
    }
    return (
        <>
            <tr>
                <td rowSpan={4} align={'center'} style={{backgroundColor:'bisque'}}>
                    <img src={require(`../image/${item.sphoto}`)} alt={item.sname}
                         style={{border: '1px solid black', width: '150px'}}/>
                    <br/>
                    <CloseSharp
                        onClick={()=>onDelete(idx)} style={{cursor:'pointer',color:'red',border:'2px solid red',borderRadius:'50%'}}></CloseSharp>
                </td>
                <th>상품번호</th>
                <td>#{idx + 1}</td>
            </tr>
            <tr>
                <th>상품명</th>
                <td>{item.sname}</td>
            </tr>
            <tr>
                <th>가격</th>
                <td>{formatCurrency(item.sprice)}</td>
            </tr>
            <tr>
                <th>색상</th>
                <td style={{height:'50px'}}>
                    <p style={{backgroundColor: item.scolor,textAlign:'center',padding:'10px',borderRadius:'20px'}}>{item.scolor}</p>
                </td>
            </tr>
        </>
    );
};

export default OneSubApp;
