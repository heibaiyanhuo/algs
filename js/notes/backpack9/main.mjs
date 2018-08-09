import { zeroOnePack } from './bp1';


const start = () => {
  let limit = 20;
  const costs = [4, 6, 11, 15, 20];
  const worths = [2, 3, 5, 7, 1];

  console.log(zeroOnePack(limit, costs, worths));
}

start();