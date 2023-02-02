var hong = {name : 'hong', first : 10, second : 20};
var shin = {name : 'shin', first : 20, second : 40};

first = 100;
second = 90;
function sum(prefix=' : '){
    return prefix + (this.first + this.second); 
};
console.log('외부 변수의 합', sum()); // sum 내부의 this : window 객체
console.log('외부 변수의 합', sum(' = '));
console.log('hong의 합', sum.call(hong)); // sum 내부의 this : hong
console.log('homg의 합', sum.call(hong, ' = ')); // 첫번째 매개변수는 this, 두번째 매개변수는 sum의 매개변수
console.log('shin의 합', sum.call(shin, ' - '));

var hongSum_ = sum.bind(hong);
console.log('bind를 이용한 hong의 합', hongSum_());

var hongSum = function (prefix=' → '){
    return prefix + (this.first + this.second); 
}.bind(hong);
console.log('bind를 이용한 hong의 합', hongSum());

var shinSum = sum.bind(shin, ' = '); // 첫번째 매개변수는 this, 두번째 매개변수는 sum의 매개변수
console.log('bind를 이용한 shin의 합', shinSum());