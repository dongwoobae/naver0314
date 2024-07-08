import React, {useState} from 'react';
import dongwonKang from '../9.jpg';
import suzi from '../19.jpg';
import sulhyun from '../15.jpg';
import sekyungShin from '../18.jpg';
import ainYu from '../20.jpg';


const SixApp=()=>{
    const [photoShow,setPhotoShow]=useState(true);
    const [photoSize,setPhotoSize]=useState(200);
    const [message,setMessage]=useState('리액트 문제 다풀면 복습 100% 보장');
    const [photo,setPhoto]=useState(sekyungShin);
    const [borderType, setBorderType] = useState('solid');
    return(
        <div style={{margin: '10px'}}>
            <h1 style={{color:"hotpink",fontSize:"45px"}}>오늘의 문제</h1>
            <hr/>
            <label>
                <input type={"checkbox"} onClick={(e) =>setPhotoShow(!e.target.checked)}/> 사진
                숨김</label>&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;
            {photoShow&&
            <button className={"btn btn-outline-danger"} onClick={() => setPhotoSize(Number(photoSize) - 10)}>점점 작게
            </button>}&emsp;
            {photoShow&&
            <button className={"btn btn-outline-danger"} onClick={() => setPhotoSize(Number(photoSize) + 10)}>점점 크게
            </button>}
            <br/><br/>
            <input type={"text"} className={"input-group"} value={message} style={{width:"400px"}}
                   onChange={e => setMessage(e.target.value)}/>
            <br/><br/>
            <div style={{display:"flex"}}>
                {photoShow&&
                <div style={{margin:"20px"}}>
                    <select onChange={(e) => setPhoto(e.target.value)}
                            className={"form-select"} style={{width: '200px', height: "50px"}} defaultValue={photo}>
                        <option value={dongwonKang}>강동원</option>
                        <option value={suzi}>수지</option>
                        <option value={sekyungShin}>신세경</option>
                        <option value={ainYu}>유아인</option>
                        <option value={sulhyun}>설현</option>
                    </select><br/><br/><br/>
                    <select onChange={(e) => setBorderType(e.target.value)}
                            className={"form-select"} style={{width: '200px', height: "50px"}} defaultValue={borderType}>
                        <option>solid</option>
                        <option>groove</option>
                        <option>inset</option>
                        <option>dashed</option>
                        <option>dotted</option>
                    </select></div>}
                {
                    photoShow&&
                <img src={photo} alt={photo} style={{width:photoSize, border:`10px ${borderType} pink`}}/>
                }
            </div>
            <h1 style={{fontFamily:"gamja flower",backgroundColor:"lightblue",color:"darkgreen",fontWeight:"bold",padding:"20px",width:"fit-content"}}>{message}</h1>
        </div>
    )
}
export default SixApp;