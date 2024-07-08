//첫 컴포넌트는 클래스 형태로 만들어보자
//Hooks 문법이 추가된 이후는 class 형태보다는
// function 형태로 많이 만든다

import {Component} from "react";

class OneApp extends Component {
    render() {
        return (
            <div>
                <h1 className="alert alert-danger">One App</h1>
            </div>
        )
    }
}

//export default OneApp; //default 는 단 한번만 사용 가능, import 시에 마음대로 이름을 지정할 수 있다.
export {OneApp};//정확히 OneApp 이라고 이름월 명명해야한다.