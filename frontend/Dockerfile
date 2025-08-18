# Use official Node LTS image (includes npm)
FROM node:20-alpine

# Set working directory
WORKDIR /usr/src/app

# Copy package files first for caching
COPY package.json package-lock.json* ./

# Install dependencies
RUN npm install

# Copy the rest of the source code
COPY . .

# Set environment variable for Vite
ENV PORT=3000

# Expose port
EXPOSE ${PORT}

# Run Vite dev server
CMD ["npm", "run", "dev"]
