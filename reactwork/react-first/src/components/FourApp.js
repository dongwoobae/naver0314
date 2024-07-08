import {useState} from "react";
import car1 from "../mycar1.png";
import car2 from "../mycar2.png";
import car3 from "../mycar3.png";
import "./MyStyle.css";

const FourApp=()=>{
    const [name, setName]=useState('이영자');
    const [age, setAge]=useState(34);
    const [addr,setAddr]=useState('서울시');
    const [photo, setPhoto]=useState(car1);
    
    return(
        <div>
            <h1 className={"alert alert-info"}>FourApp - 개인정보변경</h1>
            <table className={"table table-bordered"} style={{width: '400px'}}>
                <caption align={"top"}>개인정보 출력</caption>
                <tbody>
                <tr>
                    <th width={100} className={"table-success"}>이름</th>
                    <td width={150}>{name}</td>
                    <td rowSpan={3}><img src={photo} width={100} className={"photo line2"} alt={"자동차"}/></td>
                </tr>
                <tr>
                <th width={100} className={"table-success"}>나이</th>
                    <td>{age}</td>
                </tr>
                <tr>
                    <th width={100} className={"table-success"}>주소</th>
                    <td>{addr}</td>
                </tr>
                </tbody>
            </table>
            <div className={"input-group"} style={{width: '400px'}}>
                <input type={"text"} className={"form-control"} style={{width: '100px'}}
                       placeholder={"이름"} value={name} onChange={(e) => setName(e.target.value)}/>
                <input type={"text"} className={"form-control"} style={{width: '60px'}}
                       placeholder={"나이"} value={age} onChange={event => {
                           setAge(event.target.value)
                    // if (event.target.value<20){
                    //     setPhoto(car1);
                    //    }else if(event.target.value<50){
                    //     setPhoto(car2);
                    //    }else{
                    //     setPhoto(car3);
                    // }
                       }}
                onKeyUp={() => {
                    if(age<20) {
                    setPhoto(car1);
                    }else if(age<50){
                        setPhoto(car2);
                    }else{
                        setPhoto(car3);
                    }
                }}/>
                <input type={"text"} className={"form-control"} placeholder={"주소"} value={addr}
                       onChange={e => setAddr(e.target.value)}/>
            </div>
        </div>
    )
}

export default FourApp;