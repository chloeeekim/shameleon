import axios from 'axios'

const apiClient = axios.create({
    baseURL: process.env.NEXT_PUBLIC_API_BASE_URL || 'http://localhost:8080',
    headers: {
        'Content-Type': 'application/json',
    },
})

// 요청 인터셉터 (추후 인증 토큰 추가 시 사용)
apiClient.interceptors.request.use((config) => {
    // const token = localStorage.getItem('token')
    // if (token) {
    //   config.headers.Authorization = `Bearer ${token}`
    // }
    return config
})

// 응답 인터셉터 (에러 처리)
apiClient.interceptors.response.use(
    (response) => response,
    (error) => {
        // 공통 에러 처리 로직
        return Promise.reject(error)
    }
)

export default apiClient