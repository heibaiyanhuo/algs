const zeroOnePackBase = (limit, costs, worths) => {
  const N = costs.length;
  let dp = new Array(N + 1);
  for (let i = 0; i <= N; i++) {
    dp[i] = new Array(limit + 1).fill(0);
  }

  for (let i = 1; i <= N; i++) {
    for (let l = 0; l <= limit; l++) {
      if (l < costs[i - 1]) {
        dp[i][l] = dp[i - 1][l];
      } else {
        dp[i][l] = Math.max(dp[i - 1][l], dp[i - 1][l - costs[i - 1]] + worths[i - 1]);
      }
    }
  }

  return dp[N][limit];
}

const zeroOnePack = (limit, costs, worths) => {
  const N = costs.length;
  let dp = new Array(limit + 1).fill(0);

  for (let i = 1; i <= N; i++) {
    for (let l = limit; l >= costs[i - 1]; l--) {
      dp[l] = Math.max(dp[l], dp[l - costs[i - 1]] + worths[i - 1]);
    }
  }
  return dp[limit];
}

const zeroOneFilledPack = (limit, costs, worths) => {
  const N = costs.length;
  let dp = new Array(limit + 1).fill(Number.MIN_SAFE_INTEGER);
  dp[0] = 0;

  for (let i = 1; i <= N; i++) {    
    for (let l = limit; l >= costs[i - 1]; l--) {
      dp[l] = Math.max(dp[l], dp[l - costs[i - 1]] + worths[i - 1]);
    }
  }
  return dp[limit];
}


export { zeroOnePack };
