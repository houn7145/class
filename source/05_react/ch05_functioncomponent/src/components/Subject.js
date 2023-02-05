import './Subject.css';
const Subject = props => {
  // props.title = 'WEB'; -> readOnly, 수정 불가능
  return(
    <header className='Subject'>
      <h1 onClick={() => {
        props.onChangeMode();
      }}>
        {props.title}
      </h1>
      {props.sub}
    </header>
  );
};
export default Subject;