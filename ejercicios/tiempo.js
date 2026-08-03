export function aMinutos(x) {
    return x * 60;
}
;
export function aHoras(x) {
    return x / 60;
}
;
export function aHHMM(x) {
    const h = Math.floor(x);
    const m = Math.round((x - h) * 60);
    return `${h < 10 ? "0" + h : h}:${m < 10 ? "0" + m : m}`;
}
export function comparar(x, y) {
    if (x < y)
        return -1;
    if (x == y)
        return 0;
    return 1;
}
// Tests
console.assert(aMinutos(1) === 60);
console.assert(aMinutos(4.5) === 270);
console.assert(aHoras(60) === 1);
console.assert(aHoras(270) === 4.5);
console.assert(aHHMM(1) === "01:00");
console.assert(aHHMM(4.5) === "04:30");
console.assert(comparar(1, 4.5) === -1);
console.assert(comparar(4.5, 4.5) === 0);
console.assert(comparar(4.5, 1) === 1);
