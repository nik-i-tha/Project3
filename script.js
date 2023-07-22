const quotes = [
    "The only way to do great work is to love what you do.",
    "In the middle of difficulty lies opportunity.",
    "Believe you can and you're halfway there.",
    "The future belongs to those who believe in the beauty of their dreams.",
    "Success is not the key to happiness. Happiness is the key to success.",
    "The best way to predict the future is to create it.",
    "Don't watch the clock; do what it does. Keep going.",
    "The only limit to our realization of tomorrow will be our doubts of today.",
    "The greatest glory in living lies not in never falling, but in rising every time we fall.",
    "You miss 100% of the shots you don't take.",
    "The only person you should try to be better than is the person you were yesterday.",
    "Success is not final, failure is not fatal: It is the courage to continue that counts.",
    "The best revenge is massive success.",
    "Life is 10% what happens to us and 90% how we react to it.",
    "The harder I work, the luckier I get."
  ];
  
  function generateQuote() {
    const randomIndex = Math.floor(Math.random() * quotes.length);
    const randomQuote = quotes[randomIndex];
    document.getElementById("quote").textContent = randomQuote;
  }
  
  document.getElementById("generateBtn").addEventListener("click", generateQuote);