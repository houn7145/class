function sum(x=20, y=10){ // 디폴트 매개변수 : 값이 없으면 할당된 값을 사용
    return x+y;
};
console.log('sum(10,2) : ', sum(10,2));
console.log('sum(10) : ', sum(10));
console.log('sum() : ', sum());