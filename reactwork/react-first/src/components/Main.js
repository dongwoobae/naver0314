//Main에 각종 컴포넌트를 배치해보자
//이번에는 함수형으로 만들어보자
import {OneApp} from "./OneApp";
import TwoApp from "./TwoApp";
import ThreeApp from "./ThreeApp";
import FourApp from "./FourApp";
import FiveApp from "./FiveApp";
import {useState} from "react";
import SixApp from "./SixApp";

const Main =()=>{
    // const [showOrHide, setShowOrHide] = useState(false);
    const [idx,setIdx]=useState(6);

    return( <div style={{width:"fit-content"}}>
            {/*<SixApp/>*/}
            {/*<button type={"button"} className={"btn btn-outline-success"}*/}
            {/*onClick={()=>{*/}
            {/*    setShowOrHide(!showOrHide);*/}
            {/*}}>Show or Hide</button><br/><br/>*/}
            {/*{showOrHide && <div><FiveApp />*/}
            {/*<hr />*/}
            {/*<FourApp />*/}
            {/*<hr />*/}
            {/*<ThreeApp />*/}
            {/*<hr />*/}
            {/*<TwoApp />*/}
            {/*<hr />*/}
            {/*<OneApp />*/}
            {/*    <hr /></div>}*/}
            <h1>7월 8일 리액트 첫 수업</h1>
            <select defaultValue={idx} className={"form-select"} style={{width: '200px'}}
            onChange={(e)=>{setIdx(Number(e.target.value))}}>
                <option value={1}>1번 컴포넌트</option>
                <option value={2}>2번 컴포넌트</option>
                <option value={3}>3번 컴포넌트</option>
                <option value={4}>4번 컴포넌트</option>
                <option value={5}>5번 컴포넌트</option>
                <option value={6}>오늘의 문제</option>
            </select>
            <br/><br/>
            {
                //===3개면 type까지 맞추는 strict 한 match를 해서 Number를 씌워줘야함
                idx===1?<OneApp/>:idx===2?<TwoApp/>:
                    idx===3?<ThreeApp/>:idx===4?<FourApp/>:
                        idx===5?<FiveApp/>:<SixApp/>
            }
        </div>
    );
}

export default Main;