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
    const [showOrHide, setShowOrHide] = useState(false);
    return( <div>
            <SixApp/>
            <button type={"button"} className={"btn btn-outline-success"}
            onClick={()=>{
                setShowOrHide(!showOrHide);
            }}>Show or Hide</button><br/><br/>
            {showOrHide && <div><FiveApp />
            <hr />
            <FourApp />
            <hr />
            <ThreeApp />
            <hr />
            <TwoApp />
            <hr />
            <OneApp />
                <hr /></div>}
    </div>
    );
}

export default Main;