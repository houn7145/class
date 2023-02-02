import React, { Component } from 'react';
import './Subject.css';
class Subject extends Component{
    
    render(){
        console.log('Subject render');
        // this.props.title = 'React'; props데이터는 수정 불가능 (read only)
        return(
            <header className='subject_h'>
                <h1>
                    <a href='/'onClick={function(event){
                        event.preventDefault();
                        this.props.onChangePage();
                    }.bind(this)}>
                        {this.props.title}
                    </a>
                </h1>
                {this.props.sub}
            </header>
        );
    }
}
export default Subject;