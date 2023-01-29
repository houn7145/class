// today.getintervalDay(openday) : today부터 openday까지 기간의 날짜를 return
// this는 today, that은 openday
console.log(new Date().getTime());
Date.prototype.getintervalDay = function(that){ // this~that까지의 기간 return
    if(this>that){
        var intervalMiliSec = this.getTime() - that.getTime();
    }else{
        var intervalMiliSec = that.getTime() - this.getTime();
    } // this와 that사이의 밀리세컨을 구함
    var day = intervalMiliSec / (1000*60*60*24);
    return Math.trunc(day);
};
// var openday = new Date(2022, 10, 28, 9, 30, 0); // 개강시점 : 월은 -1
// var limitday = new Date(2023, 4, 12, 12, 20, 0); // 수료시점
// console.log(openday.getintervalDay(limitday) + '일');
// console.log(new Date().getintervalDay(limitday) + '일');
