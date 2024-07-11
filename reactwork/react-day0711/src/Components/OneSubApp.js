import React from 'react';

const OneSubApp = (prop) => {
    let {idx,item}=prop;
    return (
        <>
            <tr>
                <td rowSpan={4}>
                    <img src={require(`../image/${item.sphoto}`)} alt={item.sname}
                         style={{border: '1px solid black', width: '150px'}}/>
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
                <td>&#8361;&nbsp;{item.sprice}</td>
            </tr>
            <tr>
                <th>색상</th>
                <td>
                    <p style={{backgroundColor: item.scolor}}>{item.scolor}</p>
                </td>
            </tr>
        </>
    );
};

export default OneSubApp;
