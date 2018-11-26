const currencyTypes = [
  'twodollar',
  'dollar',
  'fiftycent',
  'twentycent',
  'tencent',
  'fivecent'
];

const currencyTypeValues = {
  fivecent: 5,
  tencent: 10,
  twentycent: 20,
  fiftycent: 50,
  dollar: 100,
  twodollar: 200,
};

const staticTill = {
  fivecent: 100,
  tencent: 320,
  twentycent: 30,
  fiftycent: 203,
  dollar: 432,
  twodollar: 23
};

function getChange(dollars, till) {
  const change = new Object();
  let centsLeft = dollars * 100;
  for (let i = 0; i < currencyTypes.length; i++) {
    const currentCurrencyType = currencyTypes[i];
    change[currentCurrencyType] = 0;
    while (centsLeft >= currencyTypeValues[currentCurrencyType] && till[currentCurrencyType] > 0) {
      centsLeft -= currencyTypeValues[currentCurrencyType];
      till[currentCurrencyType]--;
      change[currentCurrencyType]++;
    }
  }
  return change;
}
console.log(getChange(102.76, staticTill));
console.log(getChange(1.29, staticTill));
console.log(getChange(0, staticTill));