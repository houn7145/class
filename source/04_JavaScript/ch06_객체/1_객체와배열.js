const person = {'name' : '홍길동', 'age' : 20,};
person.name = '신길동'; // 변수안에 들어있는 값은 변경가능

const arr = ['홍길동', 20];
// const arr = {0 : '홍길동', 1 : 20};
console.log('arr[0] = ', arr[0], ' / arr[1] = ', arr[1]);
console.log("person['name'] = ", person['name'], " / person['age'] = ", person['age']);
console.log('person.name = ', person.name, " / persom.age = " , person.age);
