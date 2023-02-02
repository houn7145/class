class Person{
    constructor(name, first, second){ // 생성자 이름은 무조건 constructor
        this.name = name;
        this.first = first;
        this.second = second;
    }
    sum(){
        return this.first + this.second;
    }
}
var hong = new Person('홍길동', 100, 60);
console.log('홍길동의 sum : ', hong.sum());

class PersonPlus extends Person{
    constructor(name, first, second, third){ // 생성자 함수는 무조건 constructor
        super(name, first, second); // 부모 클래스 생성자 함수
        this.third = third;
    }
    sum(){
        return this.first + this.second + this.third;
        // super는 사용 불가능
    }
    avg(){
        return this.sum() / 3;
    }
}
var son = new PersonPlus('손흥민', 100, 100, 100);
console.log('손 sum : ', son.sum());
console.log('손 avg : ', son.avg());