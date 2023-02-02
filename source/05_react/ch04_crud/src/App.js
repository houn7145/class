import './App.css';
import React, {Component} from 'react';
import Subject from './components/Subject';
import ReadContent from './components/ReadContent';
import TOC from './components/TOC';
import Control from './components/Control';
import CreateContent from './components/CreateContent';
import UpdateContent from './components/UpdateContent';

class App extends Component {
  constructor(props){
    super(props);
    this.max_content_id = 3;
    this.state = {
      selected_content_id : 1,
      mode : 'welcome',
      subject : {title:'WEB', sub:'World wide web!'},
      contents : [
        {id:1, title:'HTML', desc:'HTML is HyperText Markup Language.'},
        {id:2, title:'CSS', desc:'CSS is for design'},
        {id:3, title:'JavaScript', desc:'JavaScript is for interacitive'},
      ],
      welcom : {title:'WELCOME', desc:'Hello, React!!!'},
    };
  } // 생성자
  getReadContent(){ // this.state.selected_content_id가 id인 contents안의 객체를 return
    for(var idx = 0 ; idx < this.state.contents.length ; idx++){
      var data = this.state.contents[idx];
      if(data.id === this.state.selected_content_id){
        return data;
      } // if
    } // for
  } // getReadContent
  getContent(){
    var _title, _desc, _article = null;
    if(this.state.mode === 'welcome'){
      _title = this.state.welcom.title;
      _desc = this.state.welcom.desc;
      _article = <ReadContent title={_title} desc={_desc}></ReadContent>;
    }else if(this.state.mode === 'read'){
      if(this.state.selected_content_id === 0){
          this.setState({
            mode : 'welcome',
          })
      }else{
        var data = this.getReadContent();
        _article = <ReadContent title={data.title} desc={data.desc}></ReadContent>;
      }
    }else if(this.state.mode === 'create'){
      _article = <CreateContent onChangePage={function(_title, _desc){
        // alert(_title + '/' +  _desc); 제대로 받았는 지 확인
        // this.state.content에 {id:max_content_id+1, title:_title, desc: _desc}를 push
        this.max_content_id ++;
        // this.state.contents.push( // state의 값을 변경하려면 setState()함수 이용
        //   {id:this.max_content_id, title:_title, desc:_desc}
        // );
        // 1방법 [...] 이용
        // var _contents = [...this.state.contents]; // 깊은 복사
        // _contents.push({id:this.max_content_id, title:_title, desc:_desc});

        // 2방법 concat 이용
        // var _contents = this.state.contents.concat(
        //   {id:this.max_content_id, title:_title, desc:_desc}
        // );

        // 3방법 Array.from 이용
        var _contents = Array.from(this.state.contents); // 깊은 복사
        _contents.push(
          {id:this.max_content_id, title:_title, desc:_desc}
        );
        this.setState({
          contents : _contents,
          selected_content_id : this.max_content_id,
        });
      }.bind(this)}></CreateContent>
    }else if(this.state.mode === 'update'){
      if(this.state.selected_content_id === 0){
        this.setState({
          mode : 'welcome',
        })
        alert('데이터가 존재하지 않습니다');
        return;
      }
        var _content = this.getReadContent();
        _article = <UpdateContent data={_content} onChangePage={function(_id, _title, _desc){
          // id가 _id인 contents안의 객체값을 교체 ({id:_id, title:_title, desc:_desc})
          var _contents = Array.from(this.state.contents);
          for(var idx = 0 ; idx < _contents.length ; idx++){
            if(_contents[idx].id === _id){
              // _contents[idx] = {id:_id, title:_title, desc:_desc}
              _contents[idx].title = _title;
              _contents[idx].desc = _desc;
              break;
            } // if
          } // _contents 교체완료
          this.setState({
            contents : _contents,
            mode : 'read',
          });
          // mode를 read로 바꿈
        }.bind(this)}></UpdateContent>
    } // if(mode)
    return _article;
  } // getContent()

  render(){
    console.log('app render');
    return(
      <div>
        <Subject title={this.state.subject.title}
                  sub={this.state.subject.sub}
                  onChangePage={function(){
                  this.setState({
                      mode : 'welcome',
            });
          }.bind(this)}></Subject>   

        <TOC data={this.state.contents} onChangePage={function(id){
                  this.setState({
                    mode : 'read',
                    selected_content_id : Number(id),
          });
        }.bind(this)}></TOC>

        <Control onChangePage={function(_mode){
          if(_mode === 'delete'){
            if(this.state.selected_content_id === 0){
              alert('삭제할 데이터가 없습니다');
            }else if(window.confirm('삭제하시면 복구 불가합니다. 정말 삭제할까요?')){
              // this.state.selected_content_id가 id인 contents안의 객체를 제거
              var _contents = Array.from(this.state.contents);
              for(var idx = 0 ; idx <_contents.length ; idx++){
                if(_contents[idx].id === this.state.selected_content_id){
                  _contents.splice(idx, 1); // idx번째 1개 제거
                  // read일 경우 this.state.selected_content_id를 다른 id로 교체하기 위한 정렬 작업
                  var first; // id를 기준으로 오름차순 정렬 후 첫번째 객체의 id값을 담을 예정
                  if(_contents.length>0){
                    first = Array.from(_contents).sort(function(left, right){
                              return left.id - right.id; // 오름차순 정렬
                            }).slice(0, 1)[0].id;
                  }else {
                    first = 0;
                  } // if
                  // mode를 welcome나 read로 변경
                  // read일 경우 this.state.selected_content_id를 다른 id로 교체
                  this.setState({
                    contents : _contents,
                    mode : 'read',
                    selected_content_id : first,
                  });
                  break;
                } // if
              } // for
            }// if (confirm)
          }else{
            this.setState({
              mode : _mode,
            });
          }
        }.bind(this)}></Control>
        {this.getContent()}
      </div>
    );
  }
}
export default App;
