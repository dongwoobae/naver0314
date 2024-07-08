//Main에 각종 컴포넌트를 배치해보자
//이번에는 함수형으로 만들어보자
import {OneApp} from "./OneApp";
import TwoApp from "./TwoApp";

const Main =()=>{
    return( <div>
        <OneApp/>
    <hr/>
        <TwoApp/>
        <hr/>
    </div> );
}

export default Main;