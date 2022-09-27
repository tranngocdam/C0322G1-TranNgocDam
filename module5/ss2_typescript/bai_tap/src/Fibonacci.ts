function fibonacci(n: number): number {
    if(n==0||n==1){
        return n;
    }
    return fibonacci(n-1) + fibonacci(n-2);
}

let sum=0;
let k=10;
console.log("Số Fibonacci thứ 10: "+ fibonacci(k));

for(let i=0; i<k; i++){
    console.log("Số Fibonacci thứ "+(i+1)+":"+ fibonacci(i));
    sum+=fibonacci(i);
}

console.log("Tổng 10 số Fibonacci đầu tiên: "+ sum);
